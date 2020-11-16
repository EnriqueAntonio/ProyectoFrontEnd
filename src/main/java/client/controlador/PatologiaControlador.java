package client.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import client.dominio.PatologiaDTO;
import client.servicio.PatologiaServicio;

@Controller
@RequestMapping("/patologia")
public class PatologiaControlador {

	@Autowired
	PatologiaServicio servicio;
	
	@GetMapping
	public String list(Model vista)
	{
		Map<String, Object> modelo=new HashMap<>();
		modelo=(servicio.listar());
		vista.addAttribute("patologia",modelo.get("patologiaList"));
		return "patologia";
	}
	
	@GetMapping("/crear")
	public String redirectcrear(Model model) {
		model.addAttribute("crearPatologia", new PatologiaDTO());
		return "CreatePatology";
	}
	
	@PostMapping
	public String crear(@ModelAttribute("crearPatologia")PatologiaDTO patologia)
	{
		servicio.crear(patologia);
		return "redirect:/patologia";
	}
	
	@GetMapping("/actualizar")
	public String redirectact(Model model) {
		model.addAttribute ("actPatologia", new PatologiaDTO());
		return "UpdatePato";
	}
	@PostMapping("/update")
	public String actualizar(@ModelAttribute ("actPatologia")PatologiaDTO patologia) {
		servicio.actualizar(patologia);
		return "redirect:/patologia";
	}
	@PostMapping("/delete/{id}")
	public String borrar(@PathVariable("id") Long id)
	{
		servicio.borrar(id);
		return "redirect:/patologia";
		
	}
}
