package com.myhotel;

import com.myhotel.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    Room findByNumber(String number);
    
    Iterable<Room> findAll();
    
}
