# qr
Основной файл Office_1.java, из него запускается Office_2, и внутри них все остальные. 
В Office_1 формируется запись в первой бд (Insert_data). Она кодируется qr кодом (Dinamyc_connection) и "отправляется" в Office_2. 
В Office_2 qr код расшифорвывается (Read_qr) и полученные данные заносятся во вторую бд, после чего созданная запись в бд2 обновляется "руководителем" (Update_data) (заполняются поля resolution, status и notes). После этого эта запись кодируется новым qr кодом (Dinamyc_connection2) и "отправляется" в Office_1.
В Office_1 полученный код расшифровывается (Read_qr) и расшифрованная запись вносится в первую бд (с удалением в ней уже существующей записи, созданной в начале (Delete_data)). 
