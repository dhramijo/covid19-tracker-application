package co.uk.jdreamer.covid19tracker.repositories;

import co.uk.jdreamer.covid19tracker.models.LocationStats;

import java.util.List;

public interface Covid19DataDao {

    List<LocationStats> getAllStats();

    void insertLocationStats(List<LocationStats> newStats);
}
