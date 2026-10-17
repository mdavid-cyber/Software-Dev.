let deferredPrompt;

        window.addEventListener('beforeinstallprompt', (event) => {
            // Prevent the default prompt
            event.preventDefault();
            deferredPrompt = event;

            // Show the install button
            const installButton = document.getElementById('install-button');
            installButton.hidden = false;

            installButton.addEventListener('click', async () => {
                installButton.hidden = true; // Hide the button after clicking
                deferredPrompt.prompt();

                const choiceResult = await deferredPrompt.userChoice;
                if (choiceResult.outcome === 'accepted') {
                    console.log('User accepted the install prompt');
                } else {
                    console.log('User dismissed the install prompt');
                }

                deferredPrompt = null;
            });
        });

        window.addEventListener('appinstalled', () => {
            console.log('PWA installed successfully');
        });