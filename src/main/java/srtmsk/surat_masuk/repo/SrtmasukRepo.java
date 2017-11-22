package srtmsk.surat_masuk.repo;

import srtmsk.surat_masuk.entity.Suratmasuk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SrtmasukRepo 
        extends JpaRepository<Suratmasuk,String>{
}
