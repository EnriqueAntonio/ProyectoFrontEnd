package client.controlador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class InicioControlador {

	@RequestMapping("/Inicio")
	public ModelAndView firstPage() {
		return new ModelAndView("inicio");
	}
}