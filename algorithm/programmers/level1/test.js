var solution = (participant,completion)=>
    participant.find((participant) =>
        !completion[participant]--,
        completion.map(participant =>
            completion[participant]=(completion[participant]|0)+1))
// function solution(participant, completion) {
//     var answer = '';
//     participant.sort();
//     completion.sort();
//
//     console.log(participant);
//     console.log(completion);
//     for (i in participant) {
//         if (completion[i] !== participant[i]) {
//             answer = participant[i];
//             break;
//         }
//     }
//
//     console.log(answer);
//     return answer;
// }

console.log(solution(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]));
