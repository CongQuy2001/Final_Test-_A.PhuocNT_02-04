package fis.java.com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Working_Detec_Crimis")
public class WorkingDetecCrimi {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long Id;

	@ManyToOne
	@MapsId
	@JoinColumn(name = "caseId")
	private CriminalCase criminalCase;

	@ManyToOne
	@JoinColumn(name = "detectiveId")
	private Detective detective;

}
