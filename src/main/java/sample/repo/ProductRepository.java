package sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
