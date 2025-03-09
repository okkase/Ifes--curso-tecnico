import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AudioPlayer {

    private Map<String, Clip> clips = new HashMap<>();

    public void play(String url) {
        if (!clips.containsKey(url) || clips.get(url) == null) {
            try {
                File soundFile = new File("audios/" + url); // Arquivos na pasta "audios"
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clips.put(url, clip); // Armazena o Clip

            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
                System.err.println("Erro ao tocar " + url + ": " + e.getMessage());
                e.printStackTrace();
                return; // Sai do método em caso de erro
            }
        }

        Clip clip = clips.get(url);
        if (clip.isRunning()) {
            clip.stop(); // Para antes de tocar novamente (evita sobreposição)
        }
        clip.start();
    }

    public void pause(String url) {
        if (clips.containsKey(url) && clips.get(url) != null) {
            Clip clip = clips.get(url);
            if (clip.isRunning()) {
                clip.stop();
            }
        }
    }

    public void resume(String url) {
        if (clips.containsKey(url) && clips.get(url) != null) {
            Clip clip = clips.get(url);
            if (!clip.isRunning()) {
                clip.start();
            }
        }
    }

    public void stop(String url) {
         if (clips.containsKey(url) && clips.get(url) != null) {
            Clip clip = clips.get(url);
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.close();
            clips.remove(url);
        }
    }
    public void stopAll() {
        synchronized (clips) { // Sincroniza o acesso ao HashMap
            for (Clip clip : clips.values()) {
                if (clip.isRunning()) {
                    clip.stop();
                }
                clip.close();
            }
            clips.clear(); // Limpa o HashMap após parar todas as músicas
        }
    }
    public void pauseAll() {
        synchronized (clips) { // Sincroniza o acesso ao HashMap
            for (Clip clip : clips.values()) {
                if (clip.isRunning()) {
                    clip.stop(); // Pausa a reprodução
                }
            }
        }
    }
    
    public void resumeAll() {
        synchronized (clips) { // Sincroniza o acesso ao HashMap
            for (Clip clip : clips.values()) {
                if (!clip.isRunning() && clip.getFramePosition() > 0) { // Verifica se está pausado
                    clip.start(); // Retoma a reprodução
                }
            }
        }
    }
}