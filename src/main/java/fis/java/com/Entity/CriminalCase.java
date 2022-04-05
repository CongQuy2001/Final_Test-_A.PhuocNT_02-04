package fis.java.com.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Table(name = "CriminalCases")
@Getter
@Setter
@NoArgsConstructor
public class CriminalCase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "caseId")
	private Long Id;
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private CaseType type;
	private String shortDescription;
	private String detailDescription;
	

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private CaseStatus status;
	private String notes;

	@OneToMany(mappedBy = "criminalCase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Evidence> eviddence;
	private Detective leadlinvestigator;

	@ManyToOne
	@JoinColumn(name = "detectiveId")
	private Detective detective;

	@OneToMany(mappedBy = "criminalCase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<WorkingDetecCrimi> workingDetecCrimis;

}
