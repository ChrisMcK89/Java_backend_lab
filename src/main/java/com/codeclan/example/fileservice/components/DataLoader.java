package com.codeclan.example.fileservice.components;

import com.codeclan.example.fileservice.models.File;
import com.codeclan.example.fileservice.models.Folder;
import com.codeclan.example.fileservice.models.User;
import com.codeclan.example.fileservice.repositories.FileRepository;
import com.codeclan.example.fileservice.repositories.FolderRepository;
import com.codeclan.example.fileservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {
        User user1 = new User("Bobby");
        userRepository.save(user1);

        Folder folder1 = new Folder("Music", user1);
        folderRepository.save(folder1);

        File file1 = new File("Bohemian Rhapsody", "MP3", 6574, folder1);
        File file2 = new File("Stairway to Heaven", "MP3", 8576, folder1);
        fileRepository.save(file1);
        fileRepository.save(file2);
    }
}
