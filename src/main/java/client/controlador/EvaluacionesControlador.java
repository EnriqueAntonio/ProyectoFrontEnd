package client.controlador;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import client.dominio.EvaluacionesDTO;
import client.dominio.PatologiaDTO;
import client.servicio.EvaluacionesServicio;


@Controller
@RequestMapping("/evaluaciones")
public class EvaluacionesControlador {

	@Autowired
	EvaluacionesServicio servicio;
	
	@GetMapping
	public String list(Model vista)
	{
		Map<String, Object> modelo=new HashMap<>();
		modelo=(servicio.listar());
		vista.addAttribute("evaluaciones",modelo.get("evaluacionesList"));
		return "evaluaciones";
	}
	
	@GetMapping("/crear")
	public String redirectcrear(Model model) {
		model.addAttribute("crearEvaluacion", new EvaluacionesDTO());
		return "CrearEvaluacion";
	}
	
	@PostMapping
	public String crear(@ModelAttribute("crearEvaluacion")EvaluacionesDTO evaluaciones)
	{
		servicio.crear(evaluaciones);
		return "redirect:/evaluaciones";
	}
	
	@GetMapping("/actualizar/{id}")
	public String redirectact(Model model,@PathVariable("id") Long id) {
		model.addAttribute ("actEvaluaciones", new EvaluacionesDTO());
		return "ActEvaluaciones";
	}
	
	
	
	@PostMapping("/update")
	public String actualizar(@ModelAttribute ("actEvaluaciones")EvaluacionesDTO evaluaciones) {
		
		servicio.actualizar(evaluaciones);
		return "redirect:/evaluaciones";
	}
	
	@PostMapping("/delete/{id}")
	public String borrar(@PathVariable("id") Long id)
	{
		servicio.borrar(id);
		return "redirect:/evaluaciones";
		
	}
	

}
