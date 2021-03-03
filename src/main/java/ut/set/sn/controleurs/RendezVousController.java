package ut.set.sn.controleurs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ut.set.sn.models.RendezVous;
import ut.set.sn.service.ServiceRendezVous;

@RestController
@RequestMapping("/api")
public class RendezVousController {
	ServiceRendezVous serviceRendezVous;
	
	public RendezVousController(ServiceRendezVous serviceRendezVous) {
		this.serviceRendezVous = serviceRendezVous;
	}
	@GetMapping("/")
	public String index() {
		return "Bienvenu dans mon back end";
		
	}
	@GetMapping("/getrvs")
	public ResponseEntity<List<RendezVous>> getAlls(){
		List<RendezVous> rvs = serviceRendezVous.getAllRvs();
		return new ResponseEntity<List<RendezVous>>(rvs, HttpStatus.OK);
		
	}
	@GetMapping("/chercher/{id}")
	public ResponseEntity<RendezVous> chercheRvParId(@PathVariable("id") Long id){
		RendezVous rv = serviceRendezVous.touverRvParId(id);
		return new ResponseEntity<RendezVous>(rv, HttpStatus.OK);
		
	}
	@DeleteMapping("/supprimer/{id}")
	
    public ResponseEntity<RendezVous> supprimerRvById(@PathVariable("id") Long id){
		 serviceRendezVous.supprimerUnRv(id);
		return new ResponseEntity<RendezVous>(HttpStatus.OK);
		
	}
	@PostMapping("/ajouter")
	public ResponseEntity<RendezVous> ajouterUnRv(@RequestBody RendezVous rv){
		RendezVous newRv = serviceRendezVous.ajouterRV(rv);
		
		return new ResponseEntity<RendezVous>(newRv,HttpStatus.CREATED);
		
	}
	@PutMapping("/update")
	
	public ResponseEntity<RendezVous> miseJourUnRv(@RequestBody RendezVous rv){
		RendezVous updateRv = serviceRendezVous.miseAjourRv(rv);
		return new ResponseEntity<RendezVous>(updateRv, HttpStatus.OK);
		
	}
}
