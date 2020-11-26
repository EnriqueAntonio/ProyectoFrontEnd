package client.servicio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import client.cliente.ClientePatologia;
import client.dominio.PatologiaDTO;
import client.util.ResponseDTO;

@Service
public class PatologiaServicio {
	
	@Autowired
	ClientePatologia clientebd;
	
	public Map<String, Object>listar(){
		Map<String, Object>model= new HashMap<>();
		
		try
		{
			ResponseDTO patologiaList=clientebd.listar();
			model.put("patologiaList",patologiaList.getRespuesta());
		}
		catch(Exception e)
		{
			model.put("error", "error");
			model.put("msg", "Error al extraer los datos, si su problema persiste por favor contactenos");
			e.printStackTrace();
		}
		
		return model;
	}
	
	public Map<String, Object> buscar(Long id){
		Map<String, Object>model= new HashMap<>();
		
		try
		{
			ResponseDTO patologiaBuscar=clientebd.buscar(id);
			
			model.put("patologiaBuscar",patologiaBuscar.getRespuesta());
		}
		catch(Exception e)
		{
			model.put("error", "error");
			model.put("msg", "Error al extraer los datos, si su problema persiste por favor contactenos");
			e.printStackTrace();
		}
		
		return model;
	}
	
	public Map<String, Object>crear(PatologiaDTO patologia){
		Map<String, Object>model= new HashMap<>();
		
		try {
			ResponseDTO res=clientebd.crear(patologia);
		} catch (HttpStatusCodeException  e) {
			
			model.put("msg", ResponseDTO.MSG_FATAL_ERROR);
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	public Map<String, Object>actualizar(PatologiaDTO patologia){
		Map<String, Object>model= new HashMap<>();
		
		try {
			ResponseDTO res=clientebd.actualizar(patologia);
		} catch (HttpStatusCodeException e) {
			
			model.put("msg", ResponseDTO.MSG_FATAL_ERROR);
			e.printStackTrace();
		}
		
		return model;
	}
	
	public  Map<String, Object>borrar(Long id){
		Map<String, Object>model= new HashMap<>();
		
		try {
			clientebd.borrar(id);
			
		} catch (HttpStatusCodeException e) {
			model.put("msg", ResponseDTO.MSG_FATAL_ERROR);
			e.printStackTrace();
		}
		return model;
	}

}
