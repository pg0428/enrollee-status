package com.centene.enrollee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centene.enrollee.entity.Dependent;

public interface DependentRepo extends JpaRepository<Dependent, Long> {
}
