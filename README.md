# LabTask2-3ServerPart
Серверная часть клиент-серверного приложения для лабораторной работы 2-3.

Клиент посылает произвольный набор латинских букв  серверу и получает их назад упорядоченными по алфавиту.
Сервер сделан с применением многопоточности. Каждая новая последовательность генерируется в отдельном потоке, то есть получает входные данные для генерации
выполняет генерацию, отправляет результат клиенту и завершает работу.
