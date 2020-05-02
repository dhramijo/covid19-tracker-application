package co.uk.jdreamer.covid19tracker.repositories;

import co.uk.jdreamer.covid19tracker.models.LocationStats;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Covid19DataDaoImpl implements Covid19DataDao {

    private List<LocationStats> allStats = new ArrayList<>();

    @Override
    public List<LocationStats> getAllStats() {
        return allStats;
    }

    @Override
    public void insertLocationStats(List<LocationStats> newStats) {
        this.allStats = newStats;
    }
}
