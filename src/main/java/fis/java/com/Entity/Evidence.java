package fis.java.com.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Evidences")
public class Evidence implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "evidenceId")
	private Long evidenceId;

	@ManyToOne
	@JoinColumn(name = "caseId")
	private CriminalCase criminalCase;

	@ManyToOne
	@JoinColumn(name = "storageId")
	private Storage storage;
	@Column(name = "number",unique = false)
	private String number;

	private String itemName;

	private String notes;

	private Boolean archived;

	@OneToMany(mappedBy = "evidence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TrackEntry> trackEntries;

}
