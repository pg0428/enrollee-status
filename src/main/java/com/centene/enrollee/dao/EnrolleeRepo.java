package com.centene.enrollee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centene.enrollee.entity.Enrollee;

public interface EnrolleeRepo extends JpaRepository<Enrollee, Long> {
}
