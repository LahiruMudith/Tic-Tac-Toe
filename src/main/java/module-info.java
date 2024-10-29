module  com.assignment.tictactoe.service{
    requires javafx.controls;
    requires javafx.fxml;

    exports com.assignment.tictactoe.service;
    opens com.assignment.tictactoe.service to javafx.fxml;
//    exports com.assignment.tictac
//    toe.service.Controller to javafx.fxml;
    opens com.assignment.tictactoe.service.Controller to javafx.fxml;
}