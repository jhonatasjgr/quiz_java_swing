import repositories.ListaDeQuestoes;
import telas.TelaInicial;
import telas.TelaQuestao;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        tocarMusica("C:\\Users\\JHONATAS\\Documents\\GitHub\\Programação Orientada a Objetos\\quiz_java_swing\\resources\\sound\\quiz_game_sound.wav");
        TelaInicial telaInicial = new TelaInicial();
    }

    public static void tocarMusica(String src) {
        try {
            File audio = new File(src);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);//para tocar em loop
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
//dispose() mata o anterior e aparece o proximo;
// USAR RECURSÃO - PASSAR NOVA QUESTAO,ATUAL QUANTIDADE DE ACERTOS E NO FINAL DAS 5 CHAMA A TELA DE SALVAR E AAPÓS ISSO CHAMA A TELA INICIAL