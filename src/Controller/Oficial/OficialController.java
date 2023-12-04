package Controller.Oficial;

import Controller.Controller;
import Dao.Dao;
import Model.Oficial.Oficial;
import PersonaDTO.DtoOficial;
import View.Interface.FrmOficial;
import View.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OficialController implements Controller<Oficial> {

    private View view;
    private Dao dao;
    private Map<String, Double> salarios = new HashMap<>();

    public OficialController(View view, Dao dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean create(Oficial oficial) {
          if (oficial != null) {
        DtoOficial oficialDto = new DtoOficial(
                oficial.getCedula(),
                oficial.getNombre(),
                oficial.getFechaNacimiento(),
                oficial.getTelefono(),
                oficial.getCorreo(),
                oficial.getEdad()
        );
        boolean result = dao.create(oficialDto);
        if (result) {
            salarios.put(oficial.getCedula(), oficial.getSalario());
            readAll(); // Actualizar la lista de oficiales
        }
        return result;
    }
    return false;
}

    @Override
    public Oficial read(String cedula) {
   DtoOficial oficialDto = (DtoOficial) dao.read(cedula);
        if (oficialDto != null) {
            Double salario = salarios.get(cedula);
            if (salario == null) {
                view.displayErrorMessage("Hubo un error con el salario.");
            }
            
            Oficial oficial = new Oficial(
                    salario,
                    oficialDto.getCedula(),
                    oficialDto.getNombre(),
                    oficialDto.getFechaNacimiento(),
                    oficialDto.getTelefono(),
                    oficialDto.getCorreo()
            );
            return oficial;
        } readAll();
        return null;
    }
    

    @Override
    public List<Oficial> readAll() {
     try {
        List<DtoOficial> oficialDTOs = (List<DtoOficial>) dao.readAll();
        List<Oficial> officials = new ArrayList<>(); 
        for (DtoOficial dto : oficialDTOs) {
            Double salario = salarios.get(dto.getCedula());
            if (salario == null) {
                salario = 0.0; // O manejar de manera diferente si se requiere
            }

            Oficial oficial = new Oficial(
                salario,
                dto.getCedula(),
                dto.getNombre(),
                dto.getFechaNacimiento(),
                dto.getTelefono(),
                dto.getCorreo()
            );
            officials.add(oficial);
        }

        // Imprimir para depuración
        for (Oficial oficial : officials) {
            System.out.println("Oficial: " + oficial.getCedula() + ", " + oficial.getNombre());
        }

        // Aquí es donde actualizamos la vista con la lista de oficiales
        if (view instanceof FrmOficial) { // Asegúrate de que 'view' sea una instancia de FrmOficial
            ((FrmOficial) view).displayAll(officials);
        }

        return officials;
    } catch (Exception e) {
        // Aquí capturas cualquier excepción que ocurra durante la lectura de los datos.
        System.out.println("Error en OficialController.readAll: " + e.getMessage());
        view.displayErrorMessage("Error al leer los datos de los oficiales: " + e.getMessage());
        return new ArrayList<>(); // Retorna una lista vacía o maneja según lo necesites.
    }
    }


    @Override
    public boolean update(Oficial oficial) {
         if (oficial != null) {
        DtoOficial oficialDto = new DtoOficial(
                oficial.getCedula(),
                oficial.getNombre(),
                oficial.getFechaNacimiento(),
                oficial.getTelefono(),
                oficial.getCorreo(),
                oficial.getEdad()
        );
        if (dao.update(oficialDto)) {
            view.displayMessage("Oficial actualizado correctamente");
            return true;
        } else {
            view.displayMessage("Error al actualizar el oficial");
        }
         }
        return false;
    }

    @Override
    public boolean delete(Oficial oficial) {
       List<Oficial> officials = readAll();
       if (officials.size() > 1) {
        DtoOficial oficialDto = new DtoOficial(
            oficial.getCedula(),
            oficial.getNombre(),
            oficial.getFechaNacimiento(),
            oficial.getTelefono(),
            oficial.getCorreo(),
            oficial.getEdad()
        );

        if (dao.delete(oficialDto)) {
            // Mostrar mensaje de éxito
            view.displayMessage("Oficial eliminado correctamente");
            return true;
        } else {
            view.displayMessage("Error al eliminar el oficial");
            return false;
        }
    } else {
        view.displayErrorMessage("No se puede eliminar. Debe haber al menos un oficial registrado en el sistema.");
        return false;
    }
    }

}
