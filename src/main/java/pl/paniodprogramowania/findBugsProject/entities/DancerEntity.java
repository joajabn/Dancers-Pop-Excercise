package pl.paniodprogramowania.findBugsProject.entities;

import jakarta.persistence.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.PreferredDance;

@Entity
@Table(name = "dancers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DancerEntity {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long dancerId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @Enumerated(EnumType.STRING)
    private PreferredDance preferredDance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="dancer_details_id", referencedColumnName = "dancer_details_id")
    private DancerDetailsEntity dancerDetails;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "primaballerina")
    private List<DancePlayEntity> dancePlays;

}
