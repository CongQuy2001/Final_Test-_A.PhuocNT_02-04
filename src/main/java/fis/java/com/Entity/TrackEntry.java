package fis.java.com.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TrackEntrys")
public class TrackEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trackEntryId")
	private Long trackEntryId;
	private LocalDateTime date;

	@ManyToOne
	@JoinColumn(name = "evidenceId")
	private Evidence evidence;

	@ManyToOne
	@JoinColumn(name = "detectiveId")
	private Detective detective;


	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private TrackAction action;

	private String reason;

}
