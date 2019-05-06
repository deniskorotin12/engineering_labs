from threading import Thread, Lock


x = 0


def increment_task(lock, number_of_call):
    global x
    for _ in range(number_of_call):
        lock.acquire()
        x += 1
        lock.release()


def main():
    global x
    x = 0

    lock = Lock()
    thrd1 = Thread(target=increment_task, args=(lock, 100000,))
    thrd2 = Thread(target=increment_task, args=(lock, 100000,))
    thrd1.start()
    thrd2.start()
    thrd1.join()
    thrd2.join()


if __name__ == "__main__":
    for i in range(5):
        main()
        print(f'Iteration {i}; x = {x}; (Must be 200000).')
