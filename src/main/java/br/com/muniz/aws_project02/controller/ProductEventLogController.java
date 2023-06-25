package br.com.muniz.aws_project02.controller;

import br.com.muniz.aws_project02.model.ProductEventLogDTO;
import br.com.muniz.aws_project02.repository.IProductEventLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
public class ProductEventLogController {

    private IProductEventLogRepository repository;

    @Autowired
    public ProductEventLogController(IProductEventLogRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/events")
    public List<ProductEventLogDTO> getAllEvents() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(ProductEventLogDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/events/{code}")
    public List<ProductEventLogDTO> findByCode(@PathVariable String code) {
        return repository.findAllByPk(code)
                .stream()
                .map(ProductEventLogDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/events/{code}/{event}")
    public List<ProductEventLogDTO> findByCodeAndEventType(@PathVariable String code, @PathVariable String eventType) {
        return repository.findAllByPkAndSkStartsWith(code, eventType)
                .stream()
                .map(ProductEventLogDTO::new)
                .collect(Collectors.toList());
    }

}
