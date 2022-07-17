package repository;

import entity.DijkstraAlgoritm;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan(basePackageClasses = DijkstraAlgoritm.class)
public interface DijkstraAlgoritmRepository extends JpaRepository<DijkstraAlgoritm, Integer> {

	@Override
	List<DijkstraAlgoritm> findAll();

	void deleteById(int id);

	List<DijkstraAlgoritm> findById(int id);
}
