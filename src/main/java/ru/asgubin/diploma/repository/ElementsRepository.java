package ru.asgubin.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.asgubin.diploma.entity.ElementGroups;
import ru.asgubin.diploma.entity.Elements;
import ru.asgubin.diploma.entity.FER;
import ru.asgubin.diploma.entity.FSSCm;

import java.util.List;
import java.util.Optional;

public interface ElementsRepository extends JpaRepository<Elements, Long> {

    @Query(value = "select new ru.asgubin.diploma.entity.ElementGroups(" +
            "e.mark, e.family_id, e.material_id, e.ferId, e.fsscmId, SUM(e.coast)) " +
            "from Elements AS e GROUP BY e.mark, e.family_id, e.material_id, e.ferId, e.fsscmId " +
            "order by e.mark")
    List<ElementGroups> getElementGroups();

    @Query("SELECT SUM(e.coast) FROM Elements e")
    Double getCoast();

    List<Elements> findAllByMark(String mark);
    List<Elements> findAllByOrderByMark();

    List<Elements> findAllByFerId(FER fer);
    Optional<Elements> findByFerId(FER fer);

    List<Elements> findAllByFsscmId(FSSCm fer);
    Optional<Elements> findByFsscmId(FSSCm fer);
}