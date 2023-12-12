package developer.multipleds.library;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<?> doFindAll() {
        final var libraries = libraryService.findAll();
        return ResponseEntity.ok(libraries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> doFindById(@PathVariable(name = "id") Integer id) {
        final var library = libraryService.findById(id);
        return ResponseEntity.ok(library);
    }
}
