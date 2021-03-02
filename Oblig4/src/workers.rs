class Workers{

    Workers worker_threads(4);
    Workers event_loop(1);

    worker_threads.start();
    event_loop.start();

    worker_threads.post([] {

    });

    worker_threads.post([] {

    });

    event_loop.post([] {

    });

    event_loop.post([] {

    });

    worker_threads.join();
    event_loop.join();
}