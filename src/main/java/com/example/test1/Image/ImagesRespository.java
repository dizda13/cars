package com.example.test1.Image;
import com.example.test1.Image.Image;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImagesRespository extends PagingAndSortingRepository<Image, Long> {
}
