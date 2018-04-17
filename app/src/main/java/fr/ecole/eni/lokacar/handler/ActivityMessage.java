package fr.ecole.eni.lokacar.handler;

public interface ActivityMessage {

    public void onStartMessage();

    public void onProgressMessage(int i);

    public void onEndMessage();

}
