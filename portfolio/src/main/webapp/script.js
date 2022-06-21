function addRandomGreeting() {
  const greetings =
      ['I am really tall', 'I love cooking', 'I enjoy reading a wide variety of books', 'I am a morning person'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

// Week 2 Step 3 - Get random string from hello servlet
async function getMessage() {
    const res = await fetch("/hello");
    const message = await res.json();
    const oneMessage = message[Math.floor(Math.random() * message.length)];
    document.getElementById("message-container").innerText = oneMessage;
}

// Function to get all messages from Datastore
async function loadMessages() {
    const board = document.getElementById('message-board');
    fetch("/load-messages").then(res => res.json()).then((messages) => {
        messages.forEach((message) => {
            board.appendChild(createCard(message));
        })
    });
}

// Function to create and append an html element and display the messages
function createCard(message) {
    const block = document.createElement('col');
    block.classList.add('card');
    block.id = 'card';
    const fullName = message.firstName + " " + message.lastName;
    const date = new Date(message.currentTime);
    block.innerHTML =
        `<div style='display: flex; justify-content: space-between' class='card-header'>`
        + fullName
        + " "
        + date.toLocaleDateString()
        + `</div>`
        + `<div class = 'card-body'>`
        + message.message
        + `<br/>`
        + `<small class="text-muted"> Favorite color: `
        + message.color
        + `</small>`
        + `</div>`;
    return block;
}
