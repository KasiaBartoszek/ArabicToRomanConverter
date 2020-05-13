package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model.ConversionHistory;

/**
 * This interface is responsible for integration with the database.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
@Repository
public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Integer> {
}
