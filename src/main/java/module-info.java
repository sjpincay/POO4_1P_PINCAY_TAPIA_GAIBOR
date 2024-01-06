module com.mycompany.par4_p2_pincay_tapia_gaibor {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.par4_p2_pincay_tapia_gaibor to javafx.fxml;
    exports com.mycompany.par4_p2_pincay_tapia_gaibor;
}
