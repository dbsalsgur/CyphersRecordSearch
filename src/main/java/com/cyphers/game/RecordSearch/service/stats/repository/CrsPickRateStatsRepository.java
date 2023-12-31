package com.cyphers.game.RecordSearch.service.stats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyphers.game.RecordSearch.model.stats.entity.CrsPickRateStats;

public interface CrsPickRateStatsRepository extends JpaRepository<CrsPickRateStats, String> {
	List<CrsPickRateStats> findAll();
}
