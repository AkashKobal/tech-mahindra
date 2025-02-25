
const ChatApp = {
  sessionId: undefined,
  sessionParam: undefined, 
  md2htmlConverter: undefined,
  messageContainer: undefined,
  ws: undefined,
  worker: undefined, // unused atm
  scrollAnimation: 750, // ms
  scrollAnimationEnabled: true
};

function initializeChatApp() {
  ChatApp.sessionParam = window.location.search;
  ChatApp.sessionId = ChatApp.sessionParam.split('=')[1];

  showdown.extension('showdown-extension-prism-js', function() {
    'use strict';
    var pattern = /```/g;

    return {
      type: 'lang',
      filter: function (text, converter, options) {
        var lines = text.split(/\r?\n/);

        var starting = true;
        let newLines = [];
        lines.forEach( (line) => {
          if( line.substr(0, 3) === '```' ) {
          if(starting) {
            const codeInfo = line.substring(3, line.length);
            const split = codeInfo.split(":");
            const language = split[0];
            const lines = split[1];
            let lineClass = "";
            if( lines ) {
              lineClass = ' data-line="' + lines + "\"";
            }
            newLines.push("<pre" + 
              lineClass +  
              // "data-src=\"myfile.js\" data-download-link" + 
              "><code class=\"language-" + language + "\">");
            starting = false;
          } else {
            newLines.push("</code></pre>");
            starting = true;
          }
          } else {
            newLines.push(line);
          }
        });

        return newLines.join("\n");
      },
      regex: pattern,
      replace: 'bar'
    };
  });

  Prism.plugins.toolbar.registerButton('InsertCodeBlock', (env) => { 
    let $button = $('<button/>', {
      // class: 'image-button',
      title: 'Insert at editor cursor position',
      html: '<img src="assets/imgs/insert_template.png" alt="Insert" />'
    }).css({
        border: 'none',
        backgroundColor: 'transparent',
        cursor: 'pointer',
        padding: '0'
    }); 

    $button.click( () => { // optional
      let codeblockInfo = findCodeblockIndex(env.element);
      processMessageAcceptCodeblockRequest(codeblockInfo.id, codeblockInfo.codeblockIdx, env.code);
    });

    return $button.get(0);
  });

  Prism.plugins.toolbar.registerButton('copyToClipboard', (env) => { 

    let $button = $('<button/>', {
      // class: 'image-button',
      title: 'Copy to Clipboard',
      html: '<img src="assets/imgs/paste_edit.png" alt="Copy" />'
    }).css({
      border: 'none',
      backgroundColor: 'transparent',
      cursor: 'pointer',
      padding: '0'
    });

    $button.click( async () => {
      try {
        // move copy to swt impl
        // await navigator.clipboard.writeText(env.code);
        let codeblockInfo = findCodeblockIndex(env.element);
        processMessageCopyCodeblockRequest(codeblockInfo.id, codeblockInfo.codeblockIdx, env.code);
      } catch(err) {
        alert('Copy to clipboard not supported');
      }
    });

    return $button.get(0);
  });

  ChatApp.md2htmlConverter = new showdown.Converter({
    extensions: ['showdown-extension-prism-js']
  });

  // $("#referenceContainer").accordion({
  //   active: false,
  //   collapsible: true
  // });

  ChatApp.messageContainer = document.getElementById('messageContainer');

  // chatPage toolbar setup
  $("#chatPageScrollBottomBtn").click(scrollToBottom);
  $("#chatPageScrollTopBtn").click(scrollToTop);
  $("#chatPageNewConversationBtn").click(processNewConversationRequest);
  $("#showConversationMgmtPageBtn").click(processShowConversationMgmtPageRequest);
  $("#showChatMenuBtn").click( function(evt) {
      let screenX = evt.screenX;
      let screenY = evt.screenY;
      processShowChatPageMenuRequest(screenX, screenY);
    });

    // conversationMgmtPage toolbar setup
    $("#backGroup").click(processShowChatPageRequest);
    $("#conversationMgmtPageNewConversationBtn").click(processNewConversationRequest);
    $("#conversationMgmtPageDeleteAllBtn").click(processDeleteAllConversationsRequest);

  // ChatApp.worker = new Worker('worker.js');
  // ChatApp.worker.onmessage = function(e) {
  //   // Receive the output from the worker
  //   updateProcessedMessage(e.data.visualId, e.data.content);
  // };

  // ChatApp.worker.onerror = function(error) {
  //   console.error('Worker error: ', error);
  // };

  ChatApp.wsUrl = "ws://" + window.location.host + "/chat/api/msg/command" + ChatApp.sessionParam;
  handleCreateWSClient();

  $("#messageInputInfo").css("display", "none");
}

function showChatPage() {
  $("#chatPage").show();
  $("#chatMgmtPage").hide();
}

function showChatMgmtPage() {
  $("#chatPage").hide();
  $("#chatMgmtPage").show();
}

function setTheme(theme) {
  if (!theme) return;

  for (const [key, value] of Object.entries(theme)) {
    console.log(`${key}: ${value}`);
    document.documentElement.style.setProperty(key, value);
  }

  // let background = theme['--background'];
  // if (background) {
  //   document.documentElement.style.setProperty('--background', background);
  // }
}

function markdown2html(mdContent) {
  return ChatApp.md2htmlConverter.makeHtml(mdContent);
}

function colorizeCodeblocks(element) {
  Prism.highlightAllUnder(element);
}

function findCodeblockIndex(element) {
  let cb = $(element);
  let msg = cb.closest(".message");
  let id = $(msg).attr('id');
  let msgBody = cb.closest("#messageBody");
  let codeblocks = msgBody.find('code[class^="language-"]');
  let codeblockIdx = codeblocks ? codeblocks.index(cb) : -1;

  return {id: id, codeblockIdx: codeblockIdx};
}

// Container Mgmt
const AGENT_ID = '0';

function visualId2HTMLId(visualId, includeHash) {
  return includeHash ? '#' + visualId : visualId;
}

function setScrollAnimationEnabled(enabled) {
  ChatApp.scrollAnimationEnabled = enabled;
  if (enabled) {
    scrollToBottom();
  }
}

function scrollToTop() {
  $(ChatApp.messageContainer).animate({
    scrollTop: 0
  }, ChatApp.scrollAnimationEnabled ? ChatApp.scrollAnimation : 0);
}

function scrollToBottom() {
  $(ChatApp.messageContainer).animate({
    scrollTop: $(ChatApp.messageContainer)[0].scrollHeight
  },  ChatApp.scrollAnimationEnabled ? ChatApp.scrollAnimation : 0);
}

function updateToolbarConversationName(newName) {
  newName = newName && newName.trim().length > 0 ?
     newName : '***';
  $("#toolbarConversationName").text(newName);
  $("#toolbarConversationName").attr('title', newName);
}

// Participant Mgmt
class Participant {
  constructor(id, name, avatarUrl) {
    this.id = id;
    this.name = name;
    this.avatarUrl = avatarUrl;
  }

  isAgent() {
    return this.id === AGENT_ID;
  }
}

let participants = new Map(); // key: userId, value: Participant

// API
function createParticipant(id, name, avatarUrl) {
  let participant = new Participant(id, name, avatarUrl);
  participants.set(id, participant);
  return participant;
}

function getParticipant(id) {
  return participants.get(id);
}

function removeParticipant(id) {
  participants.delete(id);
}

// Message Mgmt
let messageList = [];

function removeFromMessageList(messageElement) {
  let idx = messageList.indexOf(messageElement);
  if (idx >= 0) {
    messageList.splice(idx, 1);
  }
}

function nextMessage(messageElement) {
  let idx = messageList.indexOf(messageElement) + 1;
  if (idx == -1) return null;
  if (idx >= messageList.length) return null;
  return messageList[idx];
}

function createMessage(visualId, participantId, markdownContent) {
  // ChatApp.worker.postMessage("X");

  let $msgContainerTemplate = $('#message');
  let $message = $msgContainerTemplate.clone();
  $message.attr('id',visualId2HTMLId(visualId));
  $message.show();

  let participant = getParticipant(participantId);

  let participantType = participant.isAgent() ? 'agent' : 'user';
  $message.addClass(participantType);
  $message.data(participant, participantType);

  const $avatarNode = $message.find('#messageAvatarImg');
  $avatarNode.attr('src',participant.avatarUrl);  //'https://github.com/' + userName + '.png';
  const $userNameNode = $message.find('#messageSender');
  $userNameNode.text(participant.name);

  let hasContent = markdownContent && markdownContent.length > 0;

  // configure button click handlers
  let $closeBtnNode = $message.find('#closeBtn');
  $closeBtnNode.click(() => {
    processMessageDeleteTurnRequest(visualId);
  });

  let $thumbsUpBtnNode = $message.find('#thumbsUpBtn');
  $thumbsUpBtnNode.click( () => {
    rateMessage(visualId,1);
  });

  let $thumbsDownBtnNode = $message.find('#thumbsDownBtn');
  $thumbsDownBtnNode.click(() => {
    rateMessage(visualId, -1);
  });

  $closeBtnNode.hide();
  $thumbsUpBtnNode.hide();
  $thumbsDownBtnNode.hide();
  let $x = $message.find('#noticeContainer');
  $message.find('#noticeContainer').hide();
  $message.find('#dots').hide();

  if (hasContent) {
    let htmlContent = markdown2html(markdownContent);
    let $messageContent = $message.find('#messageBody');
    $messageContent.html(htmlContent);
    //$messageContent.html(markdownContent);
    $messageContent.data('md', markdownContent);
    colorizeCodeblocks($messageContent.get(0));
  } 

  messageList.push($message.get(0));
  ChatApp.messageContainer.appendChild($message.get(0));

  let $accordian =  $message.find("#referencesContainer"); 
  $accordian
    .accordion({
        active: false,
        collapsible: true,
        icons: {
          header: "ui-icon-triangle-1-s",
          activeHeader: "ui-icon-triangle-1-s"
        }
      })
    .hide();

  scrollToBottom();

  return $message.get(0);
}

function getMessageFromVisualId(visualId) {
  return getMessage(visualId2HTMLId(visualId, true));
}

function getMessage(htmlId) {
  let message = ChatApp.messageContainer.querySelector(htmlId);
  return message;
}

function updateMessage(visualId, markdownContent, shouldAppend) {
  let mdContent = (typeof markdownContent === 'string') ? markdownContent : "";

  let message = getMessageFromVisualId(visualId);
  let $messageContent = $(message).find('#messageBody');
  let md = shouldAppend ? $messageContent.data('md') : null;
  md = md ? md + mdContent : mdContent;
  $messageContent.data('md', md);
  // ChatApp.worker.postMessage({visualId: visualId, content: md});
  let htmlContent = markdown2html(md);
  $messageContent.html(htmlContent);
  colorizeCodeblocks($messageContent.get(0));

  scrollToBottom();
}

// used by worker architecture
//
// function updateProcessedMessage(visualId, md) {
//   let message = getMessageFromVisualId(visualId);
//   let $messageContent = $(message).find('#messageBody');
//   let htmlContent = markdown2html(md);
//   $messageContent.html(htmlContent);
//   colorizeCodeblocks($messageContent.get(0));

//   scrollToBottom();
// }

function clearMessage(visualId, allContainers) {
  let message = getMessageFromVisualId(visualId);
  let messageContent = message.querySelector('#messageBody');
  messageContent.dataset.md = null;
  messageContent.innerHTML = null;

  if (allContainers) {
   let messageHeader = message.querySelector('#messageHeader');
   let noticeContainer = messageHeader.querySelector('#noticeContainer');
   noticeContainer.innerHTML = null;
   noticeContainer.style.display = 'none';

   let messageFooter = message.querySelector('#messageFooter');
   noticeContainer = messageFooter.querySelector('#noticeContainer');
   noticeContainer.innerHTML = null;
   noticeContainer.style.display = 'none';
  }

  if (message.dataset.participant === 'agent') {
    updateMessageButtons(visualId, 0, 0, 0);
  } else {
    updateMessageButtons(visualId, 1, 0, 0);
  }
  
  scrollToBottom();
}

function addMessageLink(visualId, linkText, linkAction) {
  if (!linkText || !linkAction) return;

  let message = getMessageFromVisualId(visualId);
  let messageContent = message.querySelector('#messageBody');
  let anchorDiv = document.createElement('div');
  let anchor = document.createElement('a');
  anchor.innerText = linkText;
  anchor.addEventListener('click', window[linkAction]);
  anchorDiv.appendChild(anchor);
  messageContent.appendChild(anchorDiv);
  
  scrollToBottom();
}

// function appendMessage(visualId, markdownContent) {
//   updateMessage(visualId, markdownContent, true);

  // if (!markdownContent || markdownContent.length == 0) return;

  // let message = getMessageFromVisualId(visualId);
  // let messageContent = message.querySelector('#messageBodyP');
  // let md = messageContent.dataset.md;
  // md = md ? md + markdownContent : markdownContent;
  // let htmlContent = markdown2html(md);
  // messageContent.dataset.md = md;
  // messageContent.innerHTML = htmlContent;
  // colorizeCodeblocks(messageContent);

  // if (message.dataset.participant === 'agent') {
  //   updateMessageButtons(visualId, false, true, true);
  // } else {
  //   updateMessageButtons(visualId, true, false, false);
  // }
  
  // scrollToBottom();
// }

function setMessageCompleted(visualId) {
  showMessageActive(visualId, false);
}

function deleteMessage(visualId) {
  let message = getMessageFromVisualId(visualId);
  let messages = [message];
  if (!isAgentMessage(message)) {
    let message2 = nextMessage(message);
    if (message2) messages.push(message2);
  }
  messages.forEach( (message) => {
    ChatApp.messageContainer.removeChild(message);
    removeFromMessageList(message);
  });
}

function deleteAllMessages() {
  ChatApp.messageContainer.innerHTML = '';
  messageList = [];
}

function rateMessage(visualId, rating) {
  processMessageRatingRequest(visualId, rating);
}

function isAgentMessage(message) {
  return message.dataset.participant === 'agent';
}

function updateMessageButtons(visualId, closeBtnState, thumbsUpBtnState, 
      thumbsDownBtnState) {

    let message = getMessageFromVisualId(visualId);
    if (!message) return;
    
    let $closeBtnNode = $(message).find('#closeBtn');
    let $thumbsUpBtnNode = $(message).find('#thumbsUpBtn');
    let $thumbsDownBtnNode = $(message).find('#thumbsDownBtn');

    if (closeBtnState) {
      $closeBtnNode.show();
    } else {
      $closeBtnNode.hide();
    }

    let $inode;
    if (thumbsUpBtnState) {
      $thumbsUpBtnNode.show();
      $inode = $thumbsUpBtnNode.find('i');
      if (thumbsUpBtnState === 1) {
        $inode.removeClass('fa-solid').addClass('fa-thin');
      } else {
        $inode.removeClass('fa-thin').addClass('fa-solid');
      }
    } else {
      $thumbsUpBtnNode.hide();
    }

    if (thumbsDownBtnState) {
      $thumbsDownBtnNode.show();
      $inode = $thumbsDownBtnNode.find('i');
      if (thumbsDownBtnState === 1) {
        $inode.removeClass('fa-solid').addClass('fa-thin');
      } else {
        $inode.removeClass('fa-thin').addClass('fa-solid');
      }
    } else {
      $thumbsDownBtnNode.hide();
    }
}

function showMessageActive(visualIdOrMessage, aBool) {
  let message = (typeof visualIdOrMessage === 'string') ? 
        getMessageFromVisualId(visualIdOrMessage) :
        visualIdOrMessage;
  let dots = $(message).find('#dots');
  if (aBool) {
    $(dots).show();
  } else {
    $(dots).hide();
  }
}

function showMessageNotice(visualId, noticeType, text, location, fnName) {
  let hasText = typeof text === 'string' && text.length > 0 && text != 'null';

  let noticeTemplate = document.getElementById('notice');
  let notice = noticeTemplate.cloneNode(true);
  notice.id = visualId2HTMLId(visualId) + '-' + Date.now();

  let imageClass;
  switch (noticeType) {
    case 'INFO':
        imageClass = 'fa-circle-info';
        break;
    case 'ERROR':
      imageClass = 'error';
      break;
    case 'NORMAL':
    default:
        imageClass = 'fa-sparkles';
  }

  let noticeImage = notice.querySelector('#noticeImage');
  noticeImage.classList.add(imageClass);

  let noticeText = notice.querySelector('#noticeText');
  noticeText.textContent = hasText ? text : '';
  if (typeof fnName === 'string' && fnName.length > 0 && fnName != 'null') {
    noticeText.addEventListener('click', function() { doit(fnName); } );
    noticeText.style.cursor = 'pointer';
  }

  let message = getMessageFromVisualId(visualId);
  if (!location || location === 'FOOTER') {
    let messageFooter = message.querySelector('#messageFooter');
    let noticeContainer = messageFooter.querySelector('#noticeContainer');
    noticeContainer.appendChild(notice);
    noticeContainer.style.display = 'block';
  } else if (location === 'HEADER') {
    let messageHeader = message.querySelector('#messageHeader');
    let noticeContainer = messageHeader.querySelector('#noticeContainer');
    noticeContainer.appendChild(notice);
    noticeContainer.style.display = 'block';
  }

  scrollToBottom();
}

// ref: {filename: String, languageId: String}
function setMessageReferences(visualId, references) {
  if (!references || references.length == 0) return;

  let message = $(getMessageFromVisualId(visualId));
  let referencesContainer = $(message).find('#referencesContainer');
  let referencesHeader = $(referencesContainer).find('#referencesHeader');
  $(referencesHeader).text(`Using ${references.length} Reference${references.length > 1 ? "s" : ""}`);

  let referencesListUL = $(referencesContainer).find('ul');
  references.forEach( (ref) => {
    // <li><span class="ui-icon ui-icon-document" style="display:inline-block;"></span> Name 1</li>
    // Create the <span> element with the class and style
    let $span = $('<span></span>', {
      class: 'ui-icon ui-icon-document',
      css: {
          display: 'inline-block'
      }
    });
  
    // Create the <li> element and append the <span> and text to it
    let $li = $('<li></li>').append($span, ref);
  
    // Append the <li> to the <ul> with id="myList"
    $(referencesListUL).append($li);
  });

  $(referencesContainer).show();
  $(referencesContainer).accordion('refresh');
}

function showNotification(noticeType, text) {
  let hasText = typeof text === 'string' && text.length > 0 && text != 'null';
 
  let imageClass;
  let background;
  switch (noticeType) {
    case 'INFO':
        imageClass = 'fa-circle-info';
        background = '#74C0FC';
        break;
    case 'ERROR':
      imageClass = 'error';
      background = 'red';
      break;
    case 'NORMAL':
    default:
        imageClass = 'fa-sparkles';
        background = 'inherit';
  }

  let $messageInputInfoImage = $('#messageInputInfoImage');
  $messageInputInfoImage.addClass(imageClass);
 $("#messageInputInfo").css("display", "flex");

  let $messageInputInfoText = $('#messageInputInfoText');
  $messageInputInfoText.text(hasText ? text : '');
}

function hideNotification() {
  $("#messageInputInfo").css("display", "none");
}

function showConversationMgmtPage(data) {
  showChatMgmtPage();
  
  // remove conversationList elements
  let $conversationList = $("#conversationList");
  $conversationList.empty();

  let $conversationTemplate = $("#conversation");
  let conversationRefs = JSON.parse(data);
  conversationRefs.forEach( ref => {
    let $conversation = $conversationTemplate.clone();
    $conversation.attr('id', ref.id);
    $conversation.click( function() {
      processShowConversationRequest(ref.id);
    });

    $("#chatMgmtTitle").text('CONVERSATIONS(' + conversationRefs.length + ')');

    let $conversationName = $conversation.find('#conversationName');
    $conversationName.text(ref.name);
    let $conversationDate = $conversation.find('#conversationDate');
    $conversationDate.text(ref.createDate);

    if (ref.isMRU) {
      $conversation.addClass('mru');
      let $conversationImage = $conversation.find('i');
      $conversationImage.removeClass('fa-regular');
      $conversationImage.addClass('fa-solid');
    }

    let $conversationDeleteBtn = $conversation.find('#conversationDeleteBtn');
    $conversationDeleteBtn.click( function(event) {
      event.stopPropagation();
      processDeleteConversationRequest(ref.id);
      $conversation.remove();

      $("#chatMgmtTitle").text('CONVERSATIONS(' + $conversationList.children().length + ')');

      if ($conversationList.children().length === 0) {
        $conversationList.append(
          '<div><i>No conversations available</i></div>');
      }
    });

    $conversationList.append($conversation);
  });
}

function createConversationRef() {
}

function doit(fnName) {
  window[fnName]();
}

function buttonClicked(button) {
  // Temporarily change the icon color when clicked
  const icon = button.querySelector('i');
  icon.style.color = 'green'; // Temporary color

  // Revert the icon color after a short delay
  setTimeout(() => {
      icon.style.color = ''; // Revert to original color
  }, 100); // Adjust delay as needed
}

// API Services and interface

function handleCreateWSClient() {
  console.log("handleCreateWSClient");
  ChatApp.ws = new WebSocket(ChatApp.wsUrl);
  ChatApp.ws.onmessage = handleWSCommand;
  ChatApp.ws.onclose = handleWSClose;
  setTimeout(() => {
    if (!ChatApp.ws && ChatApp.ws.readyState !== WebSocket.OPEN) {
      console.log("handleCreateWSClient - restart");
      handleCreateWSClient();
    }
  }, 1000);
}

function handleWSCommand(event) {
  if (!event ||!event.data) return;
  let jsonString = event.data;
  console.log("handleWSCommand: " + jsonString);
  let cmdMsg = JSON.parse(jsonString);
  try {
    eval(cmdMsg.command);
  } catch (err) {
    console.error('Error processing command: ', err);
  }
}

function handleWSClose(event) {
  console.log("handleWSClose: " + event);
  setTimeout(() => {
    handleCreateWSClient();
  }, 1000);
}

function processSignOnRequest(...args) {
  sendCmd('processSignOnRequest', args);
}

function processMessageInputRequest(...args) {
  sendCmd('processMessageInputRequest', args);
}

function processMessageInputCancelRequest(...args) {
  sendCmd('processMessageInputCancelRequest', args);

}

function processTurnFollowupRequest(...args) {
  sendCmd('processTurnFollowupRequest', args);

}

function processMessageRatingRequest(...args) {
  sendCmd('processMessageRatingRequest', args);
}

function processMessageDeleteTurnRequest(...args) {
  sendCmd('processMessageDeleteTurnRequest', args);
}

function processMessageDeleteAllRequest(...args) {
  sendCmd('processMessageDeleteAllRequest', args);
}

function processMessageAcceptCodeblockRequest(...args) {
  sendCmd('processMessageAcceptCodeblockRequest', args);
}

function processMessageCopyCodeblockRequest(...args) {
  sendCmd('processMessageCopyCodeblockRequest', args);
}

function processSelectReferencesRequest(...args) {
  sendCmd('processSelectReferencesRequest', args);
}

function processOpenEditorRequest(...args) {
  sendCmd('processOpenEditorRequest', args);
}

function processRemoveReferenceRequest(...args) {
  sendCmd('processRemoveReferenceRequest', args);
}

function processNewConversationRequest(...args) {
  sendCmd('processNewConversationRequest', []);
}

function processShowChatPageMenuRequest(...args) {
  sendCmd('processShowChatPageMenuRequest', args);
}

function processShowChatPageRequest(...args) {
  sendCmd('processShowChatPageRequest', []);
}

function processShowConversationMgmtPageRequest(...args) {
  sendCmd('processShowConversationMgmtPageRequest', []);
}

function processShowConversationMgmtPageMenuRequest(...args) {
  sendCmd('processShowConvesationMgmtPageMenuRequest', args);
}

function processDeleteAllConversationsRequest(...args) {
  sendCmd('processDeleteAllConversationsRequest', []);
}

function processShowConversationRequest(...args) {
  sendCmd('processShowConversationRequest', args);
}

function processDeleteConversationRequest(...args) {
  sendCmd('processDeleteConversationRequest', args);
}

function sendCmd(cmdName, args) {
  let cmd = {
    command: cmdName,
    arguments: args
  };

  let cmdString = JSON.stringify(cmd);

  console.log('sendCmd: ', cmdString);

  let url = window.location.origin + '/chat/api/command' + ChatApp.sessionParam;
  fetch(url, { 
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: cmdString
  })
  .then(response => response.json())  // Assuming the server responds with JSON
  .then(data => console.log('Success:', data))
  .catch((error) => console.error('Error:', error));
}

// $(document).ready(setupChatApp);
document.addEventListener('DOMContentLoaded', initializeChatApp);