import exceptions.ConsoleInactiveException;

public class GameConsole {
    public enum Brand { SONY, MICROSOFT }

    private final Brand brand;
    private final String model;
    private final String serial;
    private final Gamepad firstGamepad;
    private final Gamepad secondGamepad;
    private boolean isOn;
    private Game activeGame;
    private int waitingCounter;

    public GameConsole(Brand brand, String model, String serial) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.isOn = false;
        this.waitingCounter = 0;
        this.firstGamepad = new Gamepad(brand, serial, 1);
        this.secondGamepad = new Gamepad(brand, serial, 2);
    }

    public void powerOn() {
        isOn = true;
        System.out.println("Консоль включена.");
    }

    public void powerOff() {
        isOn = false;
        System.out.println("Консоль выключена.");
    }

    public void loadGame(Game game) {
        this.activeGame = game;
        System.out.println("Игра \"" + game.getName() + "\" загружается...");
    }

    public void playGame() throws ConsoleInactiveException {
        checkStatus();
        if (activeGame == null) {
            System.out.println("Нет загруженной игры.");
            return;
        }

        System.out.println("Играем в \"" + activeGame.getName() + "\".");
        if (firstGamepad.isOn()) {
            firstGamepad.use();
        }
        if (secondGamepad.isOn()) {
            secondGamepad.use();
        }
    }

    private void checkStatus() throws ConsoleInactiveException {
        if (!firstGamepad.isOn() && !secondGamepad.isOn()) {
            waitingCounter++;
            System.out.println("Подключите джойстик. Счетчик ожидания: " + waitingCounter);
            if (waitingCounter > 5) {
                powerOff();
                throw new ConsoleInactiveException("Приставка завершает работу из-за отсутствия активности.");
            }
        } else {
            waitingCounter = 0;
        }
    }

    public class Gamepad {
        private final Brand brand;
        private final String consoleSerial;
        private final int connectedNumber;
        private double chargeLevel;
        private boolean isOn;

        public Gamepad(Brand brand, String consoleSerial, int connectedNumber) {
            this.brand = brand;
            this.consoleSerial = consoleSerial;
            this.connectedNumber = connectedNumber;
            this.chargeLevel = 100.0;
            this.isOn = false;
        }

        public void powerOn() {
            isOn = true;
            System.out.println("Джойстик " + connectedNumber + " включен.");
        }

        public void powerOff() {
            isOn = false;
            System.out.println("Джойстик " + connectedNumber + " выключен.");
        }

        public void use() {
            chargeLevel -= 10.0;
            if (chargeLevel <= 0) {
                chargeLevel = 0;
                powerOff();
                System.out.println("Джойстик " + connectedNumber + " разряжен.");
            } else {
                System.out.println("Джойстик " + connectedNumber + " используется. Остаток заряда: " + chargeLevel + "%");
            }
        }

        public boolean isOn() {
            return isOn;
        }
    }
}