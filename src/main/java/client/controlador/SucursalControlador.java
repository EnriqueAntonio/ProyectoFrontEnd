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
import client.dominio.SucursalDTO;
import client.servicio.SucursalServicio;

@Controller
@RequestMapping("/sucursal")
public class SucursalControlador {

	@Autowired
	SucursalServicio servicio;
	
	@GetMapping
	public String list(Model vista)
	{
		Map<String, Object> modelo=new HashMap<>();
		modelo=(servicio.listar());
		vista.addAttribute("sucursal",modelo.get("sucursalList"));
		return "sucursal";
	}
	
	@GetMapping("/crear")
	public String redirectcrear(Model model) {
		model.addAttribute("crearSucursal", new SucursalDTO());
		return "CrearSucursal";
	}
	
	@PostMapping
	public String crear(@ModelAttribute("crearSucursal")SucursalDTO sucursal)
	{
		servicio.crear(sucursal);
		return "redirect:/sucursal";
	}
	
	@GetMapping("/actualizar/{id}")
	public String redirectact(Model model,@PathVariable("id") Long id) {
		model.addAttribute ("ActSucursal", new SucursalDTO());
		return "ActSucursal";
	}
	
	@PostMapping("/update")
	public String actualizar(@ModelAttribute("actSucursal")SucursalDTO sucursal)
	{
		servicio.actualizar(sucursal);
		return "redirect:/sucursal";
	}
	
	@PostMapping("/delete/{id}")
	public String borrar(@PathVariable("id") Long id)
	{
		servicio.borrar(id);
		return "redirect:/sucursal";
		
	}
}
