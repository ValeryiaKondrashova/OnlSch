package school.onlineschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.onlineschool.models.Position;
import school.onlineschool.repository.PositionRepo;

import java.util.List;

@Service
public class PositionService {

    private PositionRepo positionRepo;

    @Autowired
    public PositionService(PositionRepo positionRepo) {
        this.positionRepo = positionRepo;
    }

    public List<Position> findAll(){
        return (List<Position>) positionRepo.findAll();
    }
}
