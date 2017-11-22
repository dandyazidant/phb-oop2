package srtmsk.surat_masuk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "mahasiswa")
public class Suratmasuk {
    
    @Id
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String tgl_surat;
    
    @Getter @Setter
    private String judul;
    
    @Getter @Setter
    private String kepada;
    
}
