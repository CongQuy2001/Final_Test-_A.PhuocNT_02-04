package fis.java.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fis.java.com.Entity.Evidence;
import fis.java.com.Service.IEvidenceService;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {

	@Autowired
	private IEvidenceService videnceService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> Creat(@RequestBody Evidence evidence) {
		videnceService.create(evidence);
		return new ResponseEntity<String>("create successfully! ", HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id) {

		return new ResponseEntity<Evidence>(videnceService.getByID(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")

	public ResponseEntity<?> update(@RequestBody Evidence evidence) {

		videnceService.update(evidence);
		return new ResponseEntity<String>("update successfully! ", HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
		videnceService.deleteById(id);
		return new ResponseEntity<String>("delete successfully! ", HttpStatus.OK);
	}

}
