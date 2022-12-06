package assesstment.test.rizkyazis.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produk")
@SequenceGenerator(
        name = "produk_id_seq",
        sequenceName = "produk_id_seq",
        allocationSize = 1,
        initialValue = 2)
public class Produk {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "produk_id_seq")
    private Integer id;
    @Column(name = "nama")
    private String nama;

    @Column(name = "jenis")
    private String jenis;
    @Column(name = "berat")
    private String berat;
    @ManyToOne
    @JoinColumn(name = "produsen_id")
    @JsonBackReference
    private Produsen produsen;
}
