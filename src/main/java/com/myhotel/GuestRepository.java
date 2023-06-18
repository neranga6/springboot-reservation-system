package com.myhotel;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myhotel.Guest;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

	public Guest findOne(Long geustId);
}