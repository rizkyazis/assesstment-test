package assesstment.test.rizkyazis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produsen")
@SequenceGenerator(
        name = "produsen_id_seq",
        sequenceName = "produsen_id_seq",
        allocationSize = 1,
        initialValue = 2)
public class Produsen {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "produsen_id_seq")
    private Integer id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "kode")
    private String kode;
    @Column(name = "alamat")
    private String alamat;
    @OneToMany(mappedBy = "produsen", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Produk> produk;
}


