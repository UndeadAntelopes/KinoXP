package kinoxp.kino.service;

import kinoxp.kino.model.Extras;
import kinoxp.kino.model.Movie;
import kinoxp.kino.model.Schedule;
import kinoxp.kino.repository.ExtrasRepository;
import kinoxp.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExtrasService {
        
        @Autowired
        ExtrasRepository extrasRepository;
        
        public List<Extras> fetchAll() {
            return extrasRepository.fetchAll();
        }
        
        public Extras addExtras(Extras e) {
            return extrasRepository.addExtras(e);
        }
        
        
        public void updateExtras(Extras e) {extrasRepository.updateExtras(e);}
        
        public boolean deleteExtras(int id) { return extrasRepository.deleteExtras(id);}
        
        public Extras findExtrasById(int id) {
            return extrasRepository.findExtrasById(id);
        }
        
}
    

