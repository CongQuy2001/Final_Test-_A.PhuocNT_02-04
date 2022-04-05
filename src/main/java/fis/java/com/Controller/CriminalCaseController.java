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

import fis.java.com.Entity.CriminalCase;
import fis.java.com.Service.ICriminalCaseService;

@RestController
@RequestMapping("/icriminal")
public class CriminalCaseController {
	@Autowired
	private ICriminalCaseService CaseService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> Creat(@RequestBody CriminalCase criminalCase) {
		CaseService.create(criminalCase);
		return new ResponseEntity<String>("create successfully! ", HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id) {

		return new ResponseEntity<CriminalCase>(CaseService.getByID(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")

	public ResponseEntity<?> update(@RequestBody CriminalCase criminalCase) {

		CaseService.update(criminalCase);
		return new ResponseEntity<String>("update successfully! ", HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
		CaseService.deleteById(id);
		return new ResponseEntity<String>("delete successfully! ", HttpStatus.OK);

	}

}
