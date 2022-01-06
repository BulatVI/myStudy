package com.stepik.functionalProgramming.Lesson7.Tasks1DesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class CommandPattern {
    public static void main(String[] args) {
        Speaker speaker = new SpeakerImp();

        App app = new App();

        /*app.add(new Play(speaker));
        app.add(new VolumeUp(speaker));
        app.add(new VolumeUp(speaker));
        app.add(new VolumeDown(speaker));
        app.add(new VolumeDown(speaker));
        app.add(new Pause(speaker));*/

        app.add(() -> speaker.play());
        app.add(() -> speaker.volumeUp());
        app.add(() -> speaker.volumeUp());
        app.add(() -> speaker.volumeDown());
        app.add(() -> speaker.volumeDown());
        app.add(() -> speaker.pause());

        //Более того, мы могли бы еще больше упростить код, используя ссылки на методы:
        app.add(speaker::play);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeDown);
        app.add(speaker::volumeDown);
        app.add(speaker::pause);

        app.run();
    }
}

interface Command1 {
    void execute();
}

interface Speaker {
    void volumeUp();
    void volumeDown();
    void play();
    void pause();
}
/*class VolumeUp implements Command {

    private final Speaker speaker;

    public VolumeUp(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.volumeUp();
    }
}

class VolumeDown implements Command {

    private final Speaker speaker;

    public VolumeDown(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.volumeDown();
    }
}

class Play implements Command {

    private final Speaker speaker;

    public Play(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.play();
    }
}

class Pause implements Command {
    private final Speaker speaker;
    public Pause(Speaker speaker) {
        this.speaker = speaker;
    }
    @Override
    public void execute() {
        speaker.pause();
    }
}*/
class SpeakerImp implements Speaker {
    @Override
    public void volumeUp() {
        System.out.println("volumeUp+++");
    }

    @Override
    public void volumeDown() {
        System.out.println("volumeDown---");
    }

    @Override
    public void play() {
        System.out.println("PLAY");
    }

    @Override
    public void pause() {
        System.out.println("PAUSE");
    }
}
class App {
    private final List<Command1> command1s;
    public App() {
        command1s = new ArrayList<>();
    }
    public void add(Command1 command1) {
        command1s.add(command1);
    }
    public void run() {
        for (Command1 command1 : command1s) {
            command1.execute();
        }
    }
}