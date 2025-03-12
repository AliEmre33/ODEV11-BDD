Feature: DataTables Editor Kayit Olusturma ve Arama

  Scenario: Yeni kayit olustur ve ara
    Given DataTables Editor demo sayfasina gidilir
    When Yeni bir kayit olusturulur
    And Olusturdugum kayit aranilir
    Then Kaydin tablo listesinde gorundugu dogrulanir
