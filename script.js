// Import MemoryGameModel and MemoryGameView classes from memorygamemodel and memorygameview folders respectively
import { MemoryGameModel } from './memorygamemodel/MemoryGameModel.js';
import { MemoryGameView } from './memorygameview/MemoryGameView.js';

document.addEventListener("DOMContentLoaded", function() {
    // Create an instance of MemoryGameModel and MemoryGameView
    const model = new MemoryGameModel();
    const view = new MemoryGameView();

    // Initialize the game controller
    new MemoryGameController(model, view);
});

// Define the MemoryGameController class
class MemoryGameController {
    constructor(model, view) {
        this.model = model;
        this.view = view;

        this.initializeButtons();
        this.addButtonListeners();
    }

    initializeButtons() {
        for (let i = 0; i < this.model.getNumTiles(); i++) {
            const button = this.view.createTileButton(i);
            this.view.addTileButton(button);
        }
    }

    addButtonListeners() {
        this.view.addButtonActionListener(this.handleButtonClick.bind(this));
    }

    handleButtonClick(event) {
        const clickedButton = event.target;
        const index = parseInt(clickedButton.dataset.index);
        this.revealTile(index);
    }

    revealTile(index) {
        const clickedButton = this.view.getTileButton(index);
        clickedButton.textContent = this.model.getTileValue(index);
        clickedButton.disabled = true;

        // Add logic for revealing tiles and handling matching/unmatching tiles
        // (This logic should be similar to the one in your original controller)
    }
}
