package ut.set.sn.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import ut.set.sn.exceptions.RvFoundException;
import ut.set.sn.models.RendezVous;
import ut.set.sn.repo.RendezVousRepo;

@Service

public class ServiceRendezVous {
  private RendezVousRepo rendezVousRepo;
	public ServiceRendezVous( RendezVousRepo rvrepo) {
		// TODO Auto-generated constructor stub
		this.rendezVousRepo = rvrepo;
	}
	
	public RendezVous ajouterRV(RendezVous rv) {
		rv.setCodeRv(UUID.randomUUID().toString());
		return rendezVousRepo.save(rv);
		
	}
	public List<RendezVous> getAllRvs(){
		return rendezVousRepo.findAll();
		
	}
	public void supprimerUnRv(Long id){
		rendezVousRepo.deleteById(id);
	}
  public RendezVous touverRvParId(Long id) {
	return rendezVousRepo.findById(id).orElseThrow(()-> new RvFoundException("Rv avec id" + id+ "non trouvé !!!"));
  }
  public RendezVous miseAjourRv(RendezVous rv) {
	return rendezVousRepo.save(rv);
	  
  }
}
